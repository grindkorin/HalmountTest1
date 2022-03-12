

$(document).ready(function () {
    //modal card edit
    $('.table .eBtn').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (card, status) {
            $('.myForm #id').val(card.id);
            $('.myForm #apartment').val(card.apartment.number);
            $('.myForm #clientId').val(card.client);
            $('.myForm #arrival').val(card.arrival);
            $('.myForm #leaving').val(card.leaving);
            $('[name="paid"] option[value="' + card.paid + '"]').prop('selected', 'selected');
            $('[name="prepayment"] option[value="' + card.prepayment + '"]').prop('selected', 'selected');
            $('.myForm #paidDate').val(card.paidDate);
            $('.myForm #prepaymentDate').val(card.prepaymentDate);
            $('[name="covidTest"] option[value="' + card.covidTest + '"]').prop('selected', 'selected');
            $('.myForm #bookedDate').val(card.bookedDate);
        });
        $('.myForm #exampleModal').modal('show');
    });
    // //modal card add new
    $('.table .nBtn').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (card, status) {
            $('.myForm #id').val("");
            $('.myForm #apartment').val("");
            $('.myForm #clientId').val("");
            $('.myForm #arrival').val("");
            $('.myForm #leaving').val("");
            $('[name="paid"] option[value="' + "" + '"]').prop('selected', 'selected');
            $('[name="prepayment"] option[value="' + "" + '"]').prop('selected', 'selected');
            $('.myForm #paidDate').val("");
            $('.myForm #prepaymentDate').val("");
            $('[name="covidTest"] option[value="' + "" + '"]').prop('selected', 'selected');
            $('.myForm #bookedDate').val("");
        });
        $('.myForm #exampleModal').modal('show');
    });
    //modal delete
    $('.table .dBtn').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $('#deleteModal #del').attr('href', href);
        $('#deleteModal').modal('show');
    });
});

