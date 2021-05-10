import axios from 'axios';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';


type ChartData = {
    labels: string[];
    series: number[];
}

const DonutChart = () => {

    //forma errada de ser fazer
    let ChartDate: ChartData = {labels: [], series: []};

    //FORMA ERRAD
    axios.get(`${BASE_URL}/sales/amount-by-seller`)
        .then(response => {
            const data = response.data as SaleSum[];
            const myLabels = data.map(x => x.sellerName);
            const mySeries = data.map(x => x.sum)

            ChartDate = {labels: myLabels, series: mySeries}
            console.log(ChartDate);

        });

    /*  const mockData = {
          series: [477138, 499928, 444867, 220426, 473088],
          labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
      }*/

    const options = {
        legend: {

        }
    }

    return (
        <Chart
            options={{...options, labels: ChartDate.labels}}
            series={ChartDate.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;