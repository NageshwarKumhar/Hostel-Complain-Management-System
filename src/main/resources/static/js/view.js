fetch("/complaints")

.then(response => response.json())

.then(data => {

let table = document.getElementById("tableBody");

table.innerHTML = "";

data.forEach(c => {

let row = `
<tr>
<td>${c.id}</td>
<td>${c.title}</td>
<td>${c.description}</td>
<td>${c.status}</td>
<td>
<button onclick="resolveComplaint(${c.id})">Resolve</button>
</td>
</tr>
`;

table.innerHTML += row;

});

});

function resolveComplaint(id){

fetch(`/complaints/${id}/resolve`, {

method: "PUT"

})
.then(response => response.text())
.then(data => {

alert("Complaint Resolved");

location.reload();

});

}