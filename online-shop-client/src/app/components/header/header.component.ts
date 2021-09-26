import { Component, OnInit } from '@angular/core';
import { faCoffee, faSearch } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  faCoffee = faCoffee;
  faSearch = faSearch;

  constructor() { }

  ngOnInit(): void {
  }

}
