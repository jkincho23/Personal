var palabraTraducida =  "";
var palabraTraducir = {id:"", palabra:""};
var backend ="http://localhost:8080/BKOS/api";

function loadData(){
    palabraTraducir=document.querySelector('#palabra').value;
    const request = new Request(backend+'/words/'+palabraTraducir, {method: 'GET', headers: { accept: 'application/json'}});
    (async ()=>{
        try{
            const response = await fetch(request);
            if (!response.ok) {
                alert("Si no esta en minuscula no se procesara, en caso que este en mi" +
                    "nuscula, nuestra base no tiene esta palabra");
            }
            palabraTraducida = await response.json();
            alert("Su palabra traducida es " + palabraTraducida.palabra);

        }
        catch(e){
            alert("No funciono esta vara");
        }
    })();
}
function boton(){
    var btn = document.getElementById('boton');
    btn.onclick = function (){
        loadData();
    }
}
$(boton);

