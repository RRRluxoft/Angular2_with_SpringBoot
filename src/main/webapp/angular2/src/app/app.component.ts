import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public submitted: boolean;
  roomsearch : FormGroup;
  rooms: Room[];

  ngOnInit() {
    this.roomsearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });
    this.rooms=ROOM;
  }

  onSubmit({value, valid}: {value:Roomsearch, valid:boolean}) {
    console.log(value);
  }

  reserveRoom(value:string) {
    console.log("Room id for reservation: " + value);
  }

}

export interface Roomsearch {
  checkin: string;
  checkout: string;
}


export interface Room {
  id: string;
  roomNumber: string;
  price: string;
  links: string;
}

var ROOM:Room[] = [
  {
    "id" : "321741",
    "roomNumber" : "107",
    "price" : "35",
    "links" : ""
  },
  {
    "id" : "998855663322554",
    "roomNumber" : "703",
    "price" : "205",
    "links" : ""
  },
  {
    "id" : "0000321741",
    "roomNumber" : "1071",
    "price" : "350",
    "links" : ""
  }
];
