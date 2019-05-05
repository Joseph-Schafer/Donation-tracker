import React from 'react';
import './App.css';
import { Bar } from 'react-chartjs-2';
import donationHist from './sample-donation-history.json';
import { Comment } from 'semantic-ui-react';

let data = {
  labels: ["Fundraising", "Food", "Clothing", "Medical Supplies", "Events"],
  datasets: [{
    legend: {
      display: false
    },
    backgroundColor: '#7AB9FF',
    borderColor: 'rgb(255, 99, 132)',
    data: [donationHist.users[0].totalAllocations.fundraising, 10, 5, 2, 20],
  }]

}

function App() {
  return (
    <div className="App">
      <div>
        <div id="totalAmount">total</div>
        <div id="account">Account    {JSON.stringify(donationHist.users[0].user)}
        </div>
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

          <div className="history">
            <Comment className="comment">
              <Comment.Content>
                <Comment.Content>
                ${JSON.stringify(donationHist.users[0].allocations[0].amount)} was used for {JSON.stringify(donationHist.users[0].allocations[0].cause).replace(/"/g, '')}
                </Comment.Content>
                <Comment.Metadata>
                  <span className="time">Aug 2nd 2018</span>
                </Comment.Metadata>
              </Comment.Content>
            </Comment>
            <Comment className="comment">
              <Comment.Content>
                <Comment.Content>
                ${JSON.stringify(donationHist.users[0].allocations[1].amount)} was used for {JSON.stringify(donationHist.users[0].allocations[1].cause).replace(/"/g, '')}
                </Comment.Content>
                <Comment.Metadata>
                  <span className="time">Aug 2nd 2018</span>
                </Comment.Metadata>
              </Comment.Content>
            </Comment>
            <Comment className="comment">
              <Comment.Content>
                <Comment.Content>
                  You donated $12! Thank you!
                </Comment.Content>
                <Comment.Metadata>
                  <span className="time">Aug 2nd 2018</span>
                </Comment.Metadata>
              </Comment.Content>
            </Comment>
            <Comment className="comment">
              <Comment.Content>
                <Comment.Content>
                  $5 was used for fundraising
                </Comment.Content>
                <Comment.Metadata>
                  <span className="time">Aug 2nd 2018</span>
                </Comment.Metadata>
              </Comment.Content>
            </Comment>
          </div>

        {/* <div class="history">
          <div class="historyEvent">
            <div class="historyEventTime">
              Aug 2nd 2018
            </div>
            ${JSON.stringify(donationHist.users[0].allocations[0].amount)} was used for {JSON.stringify(donationHist.users[0].allocations[0].cause).replace(/"/g, '')}
          </div>
          <div class="historyEvent">
            <div class="historyEventTime">
              Aug 2nd 2018
            </div>
            ${JSON.stringify(donationHist.users[0].allocations[0].amount)} was used for {JSON.stringify(donationHist.users[0].allocations[0].cause).replace(/"/g, '')}
          </div>
        </div> */}
      </div>
    </div>

  );
}

export default App;
