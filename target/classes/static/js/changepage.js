function changePage() {
    $('.fbutton').click(function() {
        var clickId = $(this).attr('id');
        window.location.href = clickId+".html";
    });
}