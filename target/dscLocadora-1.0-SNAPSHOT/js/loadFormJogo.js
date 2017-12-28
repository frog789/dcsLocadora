function loadFormJogo() {
    var xhttp = new xmlHttpRequest();
    xhttp.onreadystatechage = function () {
        if(this.readyState == 4 && this.status == 200){
            document.getElementById("content").innerHTML = this.responseText;
        }
    }
    xhttp.open("GET","/formJogo.xhtml", true);
    xhhtp.send();
}

