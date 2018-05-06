
    $( document ).ready(function() {

        chooseCountry();

        $('#chooseCountry').change( function() {
            updateCurrency( this.value );
        });

        $("#CalculatesTheCurrencyChange").click( function(){
            RecalculateMonthlyNettoIncomeInPLN()
        });

    });

    function updateCurrency( countryCode ) {
        countryService.getCountry( countryCode, function(country){
            $('#currencyCode').text(country.currency.code);
        });
    };

    function chooseCountry() {
        countryService.getCountries(  function(countryCollection) {
            $.each(countryCollection, function(i, country) {
                $('#chooseCountry').append('<option value="' + country.code + '">' + country.name + '</option>');
                updateCurrency( country.code );
            });
        });
    };



    function RecalculateMonthlyNettoIncomeInPLN() {
        countryService.getCountry( $('#chooseCountry').val(), function(country) {
            var workingDaysInMonth = 22;
            var monthlyNettoIncome =  $("#enteredDailyBruttoIncome").val() *  workingDaysInMonth;
            monthlyNettoIncome = monthlyNettoIncome - (monthlyNettoIncome * country.taxation.value / 100 );
            monthlyNettoIncome -=  country.taxation.constantCosts;

            // convert to PLN
            bankService.loadCurrencyRate( country.currency.code, function(rate) {
                monthlyNettoIncome *= rate;
                monthlyNettoIncome = monthlyNettoIncome.toFixed(2);
                $('#YourMonthlyNettoIncomePln').val(monthlyNettoIncome);
            });
        });
    };


