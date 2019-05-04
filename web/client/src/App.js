import React from 'react';
import './App.css';
import { Bar } from 'react-chartjs-2';
import donationHist from './sample-donation-history.json';

let data = {
  labels: ["Fundraising", "Food", "Clothing", "Medical Supplies", "Events"],
  datasets: [{
    legend: {
      display: false
    },
    backgroundColor: '#25A8FF',
    borderColor: 'rgb(255, 99, 132)',
    data: [donationHist.users[0].totalAllocations.fundraising, 10, 5, 2, 20],
  }]

}

function App() {
  return (
    <div className="App">
      <div>

      </div>
      <div class="wrapper">
        <div class="graph">
          <Bar
            data={data}
            options={{
              maintainAspectRatio: false,
              legend: {
                display: false
              }
            }}
          />
        </div>
        <div class="two">
          {JSON.stringify(donationHist.users[0].user)}
        </div>
      </div>
    </div>

  );
}

export default App;
