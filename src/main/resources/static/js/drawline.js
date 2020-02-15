function drawRoute() {
    $.ajax({
        url: 'drawRoute',
        type: 'GET',
        data: ({
           myArray: 5
        }),
        success: function (data) {
            alert("1");
            alert(data);
        },
        error: function (e) {
            alert("2");
            alert(e);
        }
    });
}

function sendInfo() {
    var inform = [];
    inform[0] = document.getElementById('start').value;
    inform[1] = document.getElementById('finish').value;
    alert(inform);
    $.ajax({
        url: 'sendinfo',
        type: 'GET',
        data: ({
           mineArray: inform
        }),
        success: function (data) {
            alert(data);
            alert("3")
        },
        error: function (e) {
            alert(e);
            alert("4")
        }
    })
}

// $(function () {
//     //появление фигуры при нажатии кнопки
//     $("#but1").click(function (e) {
//         e.preventDefault();
//         var circle = $('<line class="st1" x1=""></line>')
//         $('#planet').prepend(circle);
//
//         //появление формы при нажатии кнопки
//
//         $('.modal-window').show();
//         $('.modal-shadow').show();
//
//         $('.close').click(function () {
//             $('.modal-shadow').hide();
//             $('.modal-window').hide();
//         });
//
//         $('.closebutton').click(function () {
//             $('.modal-shadow').hide();
//             $('.modal-window').hide();
//         });
//
//     });
// });