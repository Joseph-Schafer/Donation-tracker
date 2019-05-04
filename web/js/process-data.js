const donationHistory = require('./js/process-data.js');
const Chart = require('chart.js');

var ctx = document.getElementById('myChart');

var myBarChart = new Chart(ctx, {
    type: 'bar',
    data: data,
    options: options
});

console.log("hi");