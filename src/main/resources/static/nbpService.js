var nbpService = {
    loadCurrencyRate: function(currencyCode, callback) {
      if( currencyCode != 'PLN') {
          var nbpApiUrl = 'http://api.nbp.pl/api/exchangerates/rates/a/' + currencyCode + '/?format=json';
          $.get( nbpApiUrl, function( rateInfo, status ) {
              callback( rateInfo.rates[0].mid );
          });
      }
      else {
          callback(1);
      }
  }
};