import { Component } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-form-fee',
  templateUrl: './form-fee.component.html',
  styleUrls: ['./form-fee.component.css']
})
export class FormFeeComponent {
  responseData: number = 0;

  constructor(private apiService: ApiService) { }

  arriveCountry: number = 0;
  originCountry: number = 0;

  countriesByRegion = [
    { id: 1, region: 'Norte America', countries: ['Canada', 'Estados Unidos', 'Mexico'] },
    { id: 2, region: 'Centro America', countries: ['Belice', 'Guatemala', 'El Salvador', 'Honduras', 'Nicaragua', "Costa Rica", "Panama"] },
    { id: 3, region: 'Europa', countries: ['Francia', 'Alemania', 'Reino Unido', 'Italia', 'España'] },
    { id: 4, region: 'Asia', countries: ['China', 'Catar', 'Indonesia', 'Tailandia'] },
    { id: 5, region: 'Oceania', countries: ['Australia']}
    // Puedes agregar más regiones y países según sea necesario
  ];

  total: string = "";

  package = {
    weight: 0,
    height: 0,
    large: 0,
    width: 0,
    fee : {
      idShipping: 0,
    }
  }

  onSubmit(){
    this.package.fee.idShipping = this.arriveCountry;

    this.apiService.postData(this.package).subscribe(
      (data) => {
        this.responseData = data;
        this.total = formatQuetzal.format(this.responseData);
      },
      (error) => {
        console.error('Error al obtener datos:', error);
      }
    );

    const formatQuetzal = new Intl.NumberFormat('es-GT', {
      style: 'currency',
      currency: 'GTQ',
      minimumFractionDigits: 2,
    });
  }

}
