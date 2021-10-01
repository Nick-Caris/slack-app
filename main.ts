import { DOMParser } from "https://deno.land/x/deno_dom/deno-dom-wasm.ts";

const url = "https://www.subway.com/nl-nl/menunutrition/menu/sub-of-the-day";

async function getSotd() {
    const res = await fetch(url);
    
    const body = await res.text();
    
    const doc = new DOMParser().parseFromString(body, "text/html")!;
    
    const menuCatProdTitles = doc.querySelectorAll(".menu-cat-prod-title");
    
    const dayOfWeek = (new Date().getDay() + 6) % 7;

    return menuCatProdTitles[dayOfWeek].textContent;
}

const server = Deno.listen({port: 80});
console.log("HTTP webserver running on port 80");

for await (const conn of server) {
    serveHttp(conn);
}

async function serveHttp(conn: Deno.Conn) {
    const httpConn = Deno.serveHttp(conn);

    for await (const requestEvent of httpConn) {
        const body = JSON.stringify({ 
            text: await getSotd(),
            response_type: "in_channel"
        });
        requestEvent.respondWith(
            new Response(body, {
                status: 200,
                headers: {
                    "content-type": "application/json"
                }
            }),
        );
    }
}
