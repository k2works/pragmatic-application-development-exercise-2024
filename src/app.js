console.log("App.js: loaded");
export class App {
  constructor() {
    console.log("App initialized");
    document.getElementById("app").innerHTML = `
    <body>
    <div class="todoapp">
      <form id="js-form">
        <input
          id="js-form-input"
          class="new-todo"
          type="text"
          placeholder="What need to be done?"
          autocomplete="off"
        />
      </form>
      <div id="js-todo-list" class="todo-list">
      </div>
      <footer class="footer">
        <span id="js-todo-count">Todoアイテム数: 0</span>
      </footer>
    </div>
    </body>
    `;
  }
}
