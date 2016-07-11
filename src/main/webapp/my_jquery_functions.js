$(function() {
    $('#showForm').click(function() {
       $('#results').toggle();
    });
    $('#showList').click(function() {
       $('#productList').toggle();
    });
    $('#orderadd').click(function(e){
    	
    	$("#orderForm").toggle();
    	e.preventDefault();
    });
    $('#all').click(function() {
        $.get('/orderapp/restservices/products', function(data) {
            $('#products').html('');
            for(var i = 0; i < data.length; i++) {
                var product = data[i];
                var elements = '';
                for(var l in product) {
                    elements += '<td>' + product[l] + '</td>';
                }
                $('#products').append('<tr>' + elements + '</tr>');
            }
        });
    });
    $('#orders').click(function() {
        $.get('/restservices/products/tables', function(data) {
            $('#countries').html('');
            for(var i = 0; i < data.length; i++) {
                var country = data[i];
                var elements = '';
                for(var l in country) {
                    elements += '<td>' + country[l] + '</td>';
                }
                $('#countries').append('<tr>' + elements + '</tr>');
            }
        });
    });
    $('#populations').click(function() {
        $.get('/restservices/countries/largestpopulations', function(data) {
            $('#countries').html('');
            for(var i = 0; i < data.length; i++) {
                var country = data[i];
                var elements = '';
                for(var l in country) {
                    elements += '<td>' + country[l] + '</td>';
                }
                $('#countries').append('<tr>' + elements + '</tr>');
            }
        });
    });
});