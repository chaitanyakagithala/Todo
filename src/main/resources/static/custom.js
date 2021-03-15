function newelement() {
  var li = document.createElement("li");
  var label = document.createElement("label");
  var checkbox = document.createElement("input");
  const button = document.createElement("button");

  button.innerText = "edit";
  button.className = "button";
  button.onclick = editTask;

  checkbox.type = "checkbox";
   checkbox.id = "myCheck";
   checkbox.onclick = printStatus;

  var inputvalue = document.getElementById("myinput").value;
  var textnode = document.createTextNode(inputvalue);

  label.className = "tasks";
  li.className = "listitem";
  label.appendChild(checkbox);
  label.appendChild(textnode);
  li.appendChild(label);
  li.appendChild(button);

  if (inputvalue === "") {
    alert("write something");
  } else {
    document.getElementById("list_of_things_to_do").appendChild(li);
  }
  document.getElementById("myinput").value = "";

  var span = document.createElement("span");
  var close = document.createTextNode("\u2715");
  span.className = "close";
  span.appendChild(close);
  span.onclick = remove;
  li.appendChild(span);

  const Http = new XMLHttpRequest();
  const url = "/AddTask";
  Http.open("POST", url);
  Http.setRequestHeader("Content-Type", "application/json");
  Http.send(JSON.stringify({ task: inputvalue, status: false }) );
}
function remove(event) {
  const ul = event.currentTarget.parentElement.parentElement;
  const li = event.currentTarget.parentElement;
  const label = li.getElementsByTagName("label");
  //const state = li.checkbox.checked; 
  const Http2 = new XMLHttpRequest();
  const url = "/deleteTask";
  Http2.open("POST", url);
  Http2.setRequestHeader("Content-Type", "application/json");
  Http2.send(JSON.stringify({ task: label[0].innerText,status :false}));
//console.log(JSON.stringify({ task: label[0].innerText,status :state}))
  ul.removeChild(li);
}
function update(event) {
  const li = event.currentTarget.parentElement;
  inputTag = li.firstChild;
  if (inputTag.value === "") {
    alert("write something");
  } 
  else {
    li.removeChild(li.firstChild); //removing input element
    updateButton = li.firstChild;
    li.removeChild(li.firstChild); //removing update button
    var label = document.createElement("label");
    var checkbox = document.createElement("input");
    const button = document.createElement("button");

    const errdata = updateButton.getAttribute("previousData");

    var textnode = document.createTextNode(inputTag.value);
    var span = document.createElement("span");
    var close = document.createTextNode("\u2715");

    button.innerText = "edit";
    button.className = "button";
    button.onclick = editTask;

    checkbox.type = "checkbox";
    checkbox.checked = updateButton.getAttribute("");

    label.className = "tasks";
    label.appendChild(checkbox);
    label.appendChild(textnode);
    checkbox.onclick = printStatus;

    span.className = "close";
    span.appendChild(close);
    span.onclick = remove;

    li.className = "listitem";
    li.appendChild(label);
    li.appendChild(button);
    li.appendChild(span);

    const Http = new XMLHttpRequest();
    const url = "/deleteTask";
    Http.open("POST", url);
    Http.setRequestHeader("Content-Type", "application/json");
    Http.send(JSON.stringify({ task: errdata,status :false}));
   /* console.log(JSON.stringify({ task: errdata,status :false}));*/
  const Http0 = new XMLHttpRequest();
  const url0 = "/AddTask";
  Http0.open("POST", url0);
  Http0.setRequestHeader("Content-Type", "application/json");
  Http0.send(JSON.stringify({ task: inputTag.value, status: false }) );
  console.log(JSON.stringify({ task: inputTag.value, status: false }) );
}
}

function editTask(event) {
  const ul = event.currentTarget.parentElement.parentElement;
  const li = event.currentTarget.parentElement;
  var label = li.firstChild;
  const errdata = label.innerText;
  const checkbox = label.firstChild;
  const state = checkbox.checked;
  const editdata = document.createElement("input");
  const updatebutton = document.createElement("button");

  editdata.type = "text";
  updatebutton.innerText = "update";
  editdata.value = errdata;
  updatebutton.setAttribute("previousData", errdata);
  updatebutton.setAttribute("checked", state);

  li.appendChild(editdata);
  li.appendChild(updatebutton);

  li.removeChild(li.firstChild);
  li.removeChild(li.firstChild);
  li.removeChild(li.firstChild);

  console.log(checkbox.checked);

  updatebutton.onclick = update;
  updatebutton.setAttribute("editeddata", editdata.value);
}
function printStatus(event) {
  const li = event.currentTarget.parentElement;
  const checked_value = event.currentTarget;
  const state = checked_value.checked;
  const Http3 = new XMLHttpRequest();
  const url = "/updateStatus";
  Http3.open("POST", url);
  Http3.setRequestHeader("Content-Type", "application/json");
  Http3.send(JSON.stringify({ task: li.innerText, status: state } ));
}
function renderTask(task) {
  var li = document.createElement("li");
  var label = document.createElement("label");
  var checkbox = document.createElement("input");
  const button = document.createElement("button");
  var textnode = document.createTextNode(task.task);
  var span = document.createElement("span");
  var close = document.createTextNode("\u2715");

  button.innerText = "edit";
  button.className = "button";
  button.onclick = editTask;

  checkbox.type = "checkbox";
  checkbox.checked = task.status;
  checkbox.onclick = printStatus;

  label.className = "tasks";
  label.appendChild(checkbox);
  label.appendChild(textnode);

  span.className = "close";
  span.appendChild(close);
  span.onclick = remove;

  li.className = "listitem";
  li.appendChild(label);
  li.appendChild(button);
  li.appendChild(span);
  document.getElementById("list_of_things_to_do").appendChild(li);
}

function fetchAllTasks() {
  const Http1 = new XMLHttpRequest();
  const url = "/getTaks";
  Http1.open("GET", url);
  Http1.send();
  Http1.onreadystatechange = (event) => {
    if (Http1.readyState === XMLHttpRequest.DONE) {
      const retrived_tasks = Http1.responseText;
     const arr = JSON.parse(retrived_tasks);
      arr.forEach(renderTask);
      console.log(arr.length);
     
    }
  };
}
fetchAllTasks();
