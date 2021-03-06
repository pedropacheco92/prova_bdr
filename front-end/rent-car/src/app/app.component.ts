import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  constructor(private router: Router, private translate: TranslateService) {
    this.translate.setDefaultLang('pt');
  }

  onHomeClicked() {
    this.router.navigate(['/main']);
  }

}
