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
            $('.myForm #paid').val(card.paid);
            $('.myForm #prepayment').val(card.prepayment);
            $('.myForm #paidDate').val(card.paidDate);
            $('.myForm #prepaymentDate').val(card.prepaymentDate);
            $('.myForm #covidTest').val(card.covidTest);
            $('.myForm #bookedDate').val(card.bookedDate);
        });
    });
});

alert('соси')

