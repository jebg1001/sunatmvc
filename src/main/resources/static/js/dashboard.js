google.charts.load('current', {'packages':['corechart']});

google.charts.setOnLoadCallback(graficoPrincipal);

function graficoPrincipal() {
      $.ajax({
        url: "http://localhost:8080/api/dashboard/facturas",
        dataType: "json",
      }).done(function (jsonData) {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'rucContribuyente');
        data.addColumn('number', 'montoFactura');

        jsonData.forEach(function (row) {
          data.addRow([
            row.rucContribuyente,
            row.montoFactura
          ]);
        });

        var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
        chart.draw(data, {
          width: 400,
          height: 240
        });
      }).fail(function (jq, text, err) {
        console.log(text + ' - ' + err);
      });
}

function graficoPagos() {
      $.ajax({
        url: "http://localhost:8080/api/dashboard/facturas",
        dataType: "json",
      }).done(function (jsonData) {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'rucContribuyente');
        data.addColumn('number', 'montoFactura');

        jsonData.forEach(function (row) {
          data.addRow([
            row.rucContribuyente,
            row.montoFactura
          ]);
        });

        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, {
          width: 400,
          height: 240
        });
      }).fail(function (jq, text, err) {
        console.log(text + ' - ' + err);
      });
}

function graficoEntregas() {
  $.ajax({
    url: "http://localhost:8080/api/dashboard/facturas",
    dataType: "json",
  }).done(function (jsonData) {
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'rucContribuyente');
    data.addColumn('number', 'montoFactura');

    jsonData.forEach(function (row) {
      data.addRow([
        row.rucContribuyente,
        row.montoFactura
      ]);
    });

    var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
    chart.draw(data, {
      width: 400,
      height: 240
    });
  }).fail(function (jq, text, err) {
    console.log(text + ' - ' + err);
  });
}