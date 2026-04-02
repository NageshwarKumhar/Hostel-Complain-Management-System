document.getElementById("loginForm")
.addEventListener("submit", function(e){

e.preventDefault();

const user = {

email: document.getElementById("email").value,
password: document.getElementById("password").value

};

fetch("/users/login", {

method:"POST",

headers:{
"Content-Type":"application/json"
},

body: JSON.stringify(user)

})
.then(res => res.json())
.then(data => {

if(data){

localStorage.setItem("role", data.role);

if(data.role === "ADMIN"){
window.location.href="/admin";
}

else if(data.role === "WARDEN"){
window.location.href="/warden";
}

else{
window.location.href="/dashboard";
}

}else{

alert("Invalid Credentials");

}

});

});