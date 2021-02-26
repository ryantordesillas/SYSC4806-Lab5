$('#btn').click(function(){
    $.ajax({
        url: "http://localhost:8080/create-address-book"
    }).then(function(data) {
        $('.data').append(data);
    });
});