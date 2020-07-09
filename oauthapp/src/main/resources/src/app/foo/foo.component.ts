import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Foo } from '../foo/foo';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-foo',
  templateUrl: './foo.component.html',
  styleUrls: ['./foo.component.css']
})
export class FooComponent implements OnInit {
  public foo = new Foo(1, 'sample foo');
  private foosUrl = 'http://localhost:8080/api/foos';

  constructor(private _http: HttpClient) { }

  getFoo() {
    this._http.get<Foo>(this.foosUrl+this.foo.id)
      .pipe(
        catchError(err => throwError(err.json().error()))
      ).subscribe(
        data => this.foo = data
      );
  }

  ngOnInit(): void {
  }

}
