function changePage() {
    $('.fbutton').click(function() {
        var clickId = $(this).attr('id');
        window.location.href = clickId+".html";
    });
}

function line() {
    var canvas = document.getElementById('line');
    var obCanvas = canvas.getContext('2d');

    obCanvas.beginPath();
    obCanvas.lineWidth = 2;
    obCanvas.strokeStyle = 'red';
    obCanvas.moveTo(10, 10);
    obCanvas.lineTo(290, 140);
    obCanvas.stroke();
}