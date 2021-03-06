import {Component, OnInit, ChangeDetectionStrategy, ChangeDetectorRef} from '@angular/core';
import {RestService} from "../../services/rest.service";
import {IModel, CreateModel} from "../../models/model";
import {IUser} from "../../models/test.model";
import {UserRoleService} from "../../services/user/user-role.service";
import {Response} from "@angular/http";
//  changeDetection: ChangeDetectionStrategy.OnPush

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html'
})
export class OrdersComponent implements OnInit {
  private uId: string
  private createModelobj: CreateModel;
  private uModels: IModel[] = [];
  private selectedModel:IModel;
  //CreateModel

  constructor(private restService: RestService, private roleService: UserRoleService, private cd: ChangeDetectorRef) {

  }

  ngOnInit(): void {
    this.getModelsByUserId();
    this.cd.markForCheck();

  }

  getModelsByUserId() {
    this.uId = this.roleService.getUserId();

    this.restService.getData(`./api/models/${this.uId}/list`)
      .subscribe((data: IModel[]) => {
        this.uModels = data;
      }, () => console.log('err'));
  }

  deleteModel(model: IModel) { //done
    this.restService.deleteData('/api/models/delete' + `/${model.id}`).subscribe(
      () => {
          this.uModels = this.uModels.filter(m => m !== model); //selectedModel - null

          /*if (this.selectedModel === model) {
            this.selectedModel = null;      }*/
        }
    )
  }

  createModel() {
    let iid = this.roleService.getUserId(); //todo: RE
    let createModelobjT: any = {
      "approved": "NEW",
      "bagTypeId": 1,
      "mname": "string",
      "userId": iid
    };
    this.restService.postJson('./api/models/create', createModelobjT).subscribe(
      () => {
        this.uModels.push(createModelobjT);
        this.selectedModel = null;
        this.getModelsByUserId();
      }
    )

  }

}

/*this.restService.postJson('./api/user/create', this.model)
 .subscribe(
 UserCreate => {
 UserCreate => this.model = new UserCreate(password, email, firstName, lastName);
 this.alertService.success('Registration successful', true);
 this.router.navigate(['/login']);
 },
 error => {
 this.alertService.error(error);
 this.errorMessage = <any>error;
 this.loading = false;
 }
 );

 export class newsStatus{
 idnews: number;
 type: string;
 }


 */



