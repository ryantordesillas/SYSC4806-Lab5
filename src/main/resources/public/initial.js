$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/address-books"
    }).then(function(data) {
        $('.data').append(data);
    });
});