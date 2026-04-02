fetch("/complaints", {
headers: {
	"role": localStorage.getItem("role")
}
})
.then(res => res.json())
.then(data => {

document.getElementById("total").innerText = data.length;

let pending = data.filter(c => c.status === "Pending").length;
let resolved = data.filter(c => c.status === "Resolved").length;

document.getElementById("pending").innerText = pending;
document.getElementById("resolved").innerText = resolved;

let recent = document.getElementById("recentTable");
recent.innerHTML = "";   // Clear before adding

data.slice(-5).reverse().forEach(c => {

let row = `
<tr>
<td>${c.id}</td>
<td>${c.title}</td>
<td>${c.status}</td>
</tr>
`;

recent.innerHTML += row;

});

});