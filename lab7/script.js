$(document).ready(function () {
    get();
    getDistinctTypes();
});
let lastVal="None";
let current="None";
$(document).on('click',"#changeButton", function () {
    $("#form1").show();
});

$(document).on('change',"#dropDown", function () {
    let valoare = $('#dropDown').val();
    lastVal = current;
    current = valoare;
    let request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if(request.readyState === 4 && request.status === 200){
            let response = request.responseText;
            response = response.split(";");
            document.getElementById("tableBody").innerText = "";
                for (let i in response) {
                    if (response[i] != "") {
                        const doc = response[i].split("#");
                        document.getElementById("tableBody").innerHTML +=
                            "<tr>" +
                            "<td>" + doc[0] + "</td>" +
                            "<td>" + doc[1] + "</td>" +
                            "<td>" + doc[2] + "</td>" +
                            "<td>" + doc[3] + "</td>" +
                            "<td>" + doc[4] + "</td>" +
                            "<td>" + doc[5] + "</td>" +
                            "</tr>";
                        i += 1;
                    }
                }
            $('#LastSearched').html( "Last type selected: " + lastVal);
            }
    };
    request.open('GET', 'getFilter.php' + '?' + 'type=' + valoare);
    request.send();
    });

function get() {
    const req = new XMLHttpRequest();
    req.onreadystatechange= function () {
        if( req.readyState ==4 && req.status == 200){
            let response = req.responseText;
            response = response.split(";");

            for (let i in response){
                if(response[i]!= "") {
                    const doc = response[i].split("#");
                    document.getElementById("tableBody").innerHTML +=
                        "<tr>" +
                        "<td>" + doc[0] + "</td>" +
                        "<td>" + doc[1] + "</td>" +
                        "<td>" + doc[2] + "</td>" +
                        "<td>" + doc[3] + "</td>" +
                        "<td>" + doc[4] + "</td>" +
                        "<td>" + doc[5] + "</td>" +
                        "</tr>";
                    i += 1;
                }
            }
        }
    };
    req.open('GET','getAll.php',true);
    req.send('');
}

function getDistinctTypes() {
    let request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            let response = request.responseText;
            response = response.split(";");
            for (const i in response) {
                if (response[i] !== "") {
                    let newOps = document.createElement("option");
                    newOps.setAttribute("value", response[i]);
                    newOps.innerHTML = response[i];
                    document.getElementById("dropDown").appendChild(newOps);
                }
            }
        }
    };
    request.open('GET', 'getDistinctTypes.php', true);
    request.send();
}
