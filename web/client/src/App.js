import React from 'react';
import logo from './logo.svg';
import './App.css';
import { Bar } from 'react-chartjs-2';
import donationHist from './sample-donation-history.json';

let data = {
  labels: ["January", "February", "March", "April", "May", "June", "July"],
  datasets: [{
    label: "My First dataset",
    backgroundColor: 'rgb(255, 99, 132)',
    borderColor: 'rgb(255, 99, 132)',
    data: [0, 10, 5, 2, 20, 30, 45],
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
            options={{ maintainAspectRatio: false }}
          />
        </div>
        <div class="two">
          John Smith
          {JSON.stringify(donationHist.users[0].user)}
        </div>
      </div>
    </div>

  );
}

export default App;
