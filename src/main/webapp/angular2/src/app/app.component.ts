import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {Headers, Http, RequestOptions, Response} from "@angular/http";
import {Observable} from "rxjs/index";
import {map} from 'rxjs/operators';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(private http:Http) {};
  private baseUrl: string = "http://localhost:8080";
  public submitted: boolean;
  roomsearch : FormGroup;
  rooms: Room[];
  currentChechInVal:string;
  currentChechOutVal:string;
  private request: ReserveRoomRequest;

  ngOnInit() {
    this.roomsearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });

    const roomsearchValChanges$ = this.roomsearch.valueChanges;

    roomsearchValChanges$.subscribe(valCheck => {
        this.currentChechInVal = valCheck.checkin;
        this.currentChechOutVal = valCheck.checkout;
    });
  }

  onSubmit({value, valid}: {value:Roomsearch, valid:boolean}) {
    return this.getAll()
      .subscribe(rooms => this.rooms = rooms,
        err => {console.log(err)}
        );
  }

  reserveRoom(value:string) {
    console.log("Room id for reservation: " + value);
    this.request = new ReserveRoomRequest(value, this.currentChechInVal, this.currentChechOutVal)
  }

  getAll():Observable<Room[]> {
    return this.http.get(this.baseUrl + '/room/reservation/v1?checkin=' + this.currentChechInVal
      + '&checkout=' + this.currentChechOutVal).pipe(
      map(this.mapRoom));
  }

  createReservation(body:ReserveRoomRequest) {
    let bodyString = JSON.stringify(body);
    let headers = new Headers({'Content-Type':'application/json'});
    // let options = new RequestOptions({headers: headers});
    let options = new RequestOptions({headers: headers});
    this.http.post(this.baseUrl + '/room/reservation/v1', body, options)
      .subscribe(res => console.log(res));
  }

  mapRoom(response: Response): Room[] {
    return response.json().content;
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

export class ReserveRoomRequest {
  roomId:string;
  checkin:string;
  checkout:string;

  constructor(roomId:string,
  checkin:string,
  checkout:string) {
    this.roomId = roomId;
    this.checkin = checkin;
    this.checkout = checkout;
  }

}
