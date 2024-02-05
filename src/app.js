import { TodoListModel } from "./model/TodoListModel.js";
import { TodoItemModel } from "./model/TodoItemModel.js";
import { element, render } from "./view/html-util.js";

export class App {
  constructor() {
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
        <!-- 動的に更新されるTodoリスト -->
      </div>
      <footer class="footer">
        <span id="js-todo-count">Todoアイテム数: 0</span>
      </footer>
    </div>
    </body>
    `;
  }

  #todoListModel = new TodoListModel();

  mount() {
    const formElement = document.querySelector("#js-form");
    const inputElement = document.querySelector("#js-form-input");
    const containerElement = document.querySelector("#js-todo-list");
    const todoItemCountElement = document.querySelector("#js-todo-count");
    //! [checkbox]
    this.#todoListModel.onChange(() => {
      const todoListElement = element`<ul></ul>`;
      const todoItems = this.#todoListModel.getTodoItems();
      todoItems.forEach(item => {
        // 削除ボタン(x)をそれぞれ追加する
        const todoItemElement = item.completed
            ? element`<li><input type="checkbox" class="checkbox" checked>
                        <s>${item.title}</s>
                        <button class="delete">x</button>
                    </li>`
            : element`<li><input type="checkbox" class="checkbox">
                        ${item.title}
                        <button class="delete">x</button>
                    </li>`;
        // チェックボックスのトグル処理は変更なし
        const inputCheckboxElement = todoItemElement.querySelector(".checkbox");
        inputCheckboxElement.addEventListener("change", () => {
          this.#todoListModel.updateTodo({
            id: item.id,
            completed: !item.completed
          });
        });
        // 削除ボタン(x)がクリックされたときにTodoListModelからアイテムを削除する
        const deleteButtonElement = todoItemElement.querySelector(".delete");
        deleteButtonElement.addEventListener("click", () => {
          this.#todoListModel.deleteTodo({
            id: item.id
          });
        });
        todoListElement.appendChild(todoItemElement);
      });
      render(todoListElement, containerElement);
      todoItemCountElement.textContent = `Todoアイテム数: ${this.#todoListModel.getTotalCount()}`;
    });
    //! [checkbox]
    formElement.addEventListener("submit", (event) => {
      event.preventDefault();
      this.#todoListModel.addTodo(new TodoItemModel({
        title: inputElement.value,
        completed: false
      }));
      inputElement.value = "";
    });
  }
}
