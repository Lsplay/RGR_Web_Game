swordbutton.onclick=function(){
   sendUserToServer('/game/fighpath',"action=sword");
}
shildbutton.onclick=function(){
    sendUserToServer('/game/fighpath',"action=shild");
 }
kickbutton.onclick=function(){
    sendUserToServer('/game/fighpath',"action=kick");
 }

function sendToServer(address,body){
    let xhr= new XMLHttpRequest();
    xhr.open('POST', address,true );
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    
    xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			show();
		} else {
		}
	};
   
	xhr.send(body);

}


window.onload=function(){
  if( [[${first}]]!=null){
      document.getElementById("first").src="/images/fight/[[${first}]].png";
  }
};