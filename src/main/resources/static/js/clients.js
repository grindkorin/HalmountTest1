

$(document).ready(function () {
    //modal client edit
    $('.table .eBtn').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (client, status) {
            $('.myForm #id').val(client.id);
            $('.myForm #lastName').val(client.lastName);
            $('.myForm #name').val(client.name);
            $('.myForm #patronymic').val(client.patronymic);
            // $('.myForm #').val(client.registrationCards);
            $('.myForm #phone').val(client.contacts.phone);
            $('.myForm #email').val(client.contacts.email);
         });
        $('.myForm #exampleModal').modal('show');
    });
    // //modal client add new
    $('.table .nBtn').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (client, status) {
            $('.myForm #id').val("");
            $('.myForm #lastName').val("");
            $('.myForm #name').val("");
            $('.myForm #patronymic').val("");
            // $('.myForm #').val(client.registrationCards);
            $('.myForm #phone').val("");
            $('.myForm #email').val("");
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

