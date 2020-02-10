var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    } else {
        $("#conversation").hide();
    }
    $("#userinfo").html("");
}

function connect() {
    var socket = new SockJS('/websocket-example');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/user', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    //stompClient.send("/app/user", {}, JSON.stringify({'accountId': $("#accountId").val(), 'stake': $("#stake").val()}));
    var acc = []

    $.ajax({
        type: 'POST',
        url: '/demo/message',
        data: JSON.stringify({'accountId': $("#accountId").val(), 'stake': $("#stake").val()}),
        error: function(data) {
            $.each(data.responseJSON.errors, function(index, value) {
                acc.push(value.description);
            });
            alert('errors: ' + JSON.stringify(acc));
        },
        contentType: "application/json",
        dataType: 'json'
    });
}

function showGreeting(message) {
    $("#userinfo").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendName();
    });
});