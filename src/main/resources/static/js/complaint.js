document.getElementById("complaintForm")
.addEventListener("submit", function(e){

e.preventDefault();

const complaint = {
title: document.getElementById("title").value,
description: document.getElementById("description").value
};

fetch("http://localhost:8080/complaints", {

method: "POST",
headers: {
"Content-Type": "application/json",
"role": localStorage.getItem("role")
},
body: JSON.stringify(complaint)

})
.then(response => response.json())
.then(data => {

alert("Complaint Submitted Successfully");
window.location.href="/dashboard";

});

});