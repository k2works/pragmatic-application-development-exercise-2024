console.log("App.js: loaded");
export class App {
  constructor() {
    console.log("App initialized");
    document.getElementById("app").innerHTML = `
    <body>
      <h1>Todo App</h1>
    </body>
    `;
  }
}
