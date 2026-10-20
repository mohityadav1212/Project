let stompClient = null;
let user = null;
 
 const socket = new SockJS('/ws-endpoints');
 stompClient = Stomp.over(socket);

stompClient.connect({}, ()=>{
    console.log('Connected to websocket server');

    stompClient.subscribe('/topic/messages', (message)=>{
    //  console.log('Received message:', message);

    const li = document.createElement('li');
    const msg = JSON.parse(message.body);
    li.innerHTML = msg.content+"(by " +msg.sender +" at " + msg.timeStamp + ")";

    const messageList = document.getElementById('messageList');
    messageList.appendChild(li);

    });
});


function sendMessage(){
    const message = document.getElementById('messageInput').value;
//  console.log(" Sending message" , message);

  stompClient.send("/app/chat",{}, JSON.stringify(
    {
        'sender': user,
        'content': message,
        'type':  'CHAT',
        'timeStamp': new Date().toISOString()
}

));
}

function connect(){
    user = document.getElementById('uname').value;
    document.getElementById('loginDiv').style.display = 'none';
    document.getElementById('msgBlock').style.display = 'block';

    document.getElementById('userName').innerText = 'you are logeed in as,' + user + '!';
}