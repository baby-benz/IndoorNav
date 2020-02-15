// $(function() {
//    $("#floor3").click(function (e) {
//        alert("KEK");
//        window.location.href = "floor3.html";
//    })
// });

function changePage() {
    $('.fbutton').click(function() {
        var clickId = $(this).attr('id');
        window.location.href = clickId+".html";
    });
}