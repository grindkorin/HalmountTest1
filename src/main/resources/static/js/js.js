
//apartments
$(document).ready(function () {
    //modal apartment edit
    $('.table .eBtn').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (apartment, status) {
            $('.myForm #id').val(apartment.id);
            $('.myForm #number').val(apartment.number);
      //      $('.myForm #booked').val(apartment.booked);
            $('[name="booked"] option[value="' + apartment.booked + '"]').prop('selected', 'selected');
            $('[name="occupied"] option[value="' + apartment.occupied + '"]').prop('selected', 'selected');
        //    $('.myForm #occupied').val(apartment.occupied);
        });
        $('.myForm #exampleModal').modal('show');
    });
    // //modal apartment add new
    $('.table .nBtn').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (apartment, status) {
            $('.myForm #id').val("");
           $('.myForm #number').val("");
        //    $('.myForm #booked').val("");
          //  $('.myForm #occupied').val("");
            $('[name="booked"] option[value="' + "" + '"]').prop('selected', 'selected');
            $('[name="occupied"] option[value="' + "" + '"]').prop('selected', 'selected');
        });
        $('.myForm #exampleModal').modal('show');
    });

    $('.table .dBtn').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $('#deleteModal #del').attr('href', href);
        $('#deleteModal').modal('show');
    });
});


$("input").change(function(){
    $(this).siblings("input").prop('checked', false);
});

$("form #newBooking").submit(function(){
    if($("input:checked").length > 1){
        alert('error!');
        return false;
    }
});
