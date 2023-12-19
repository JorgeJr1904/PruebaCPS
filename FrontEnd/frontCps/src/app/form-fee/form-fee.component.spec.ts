import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormFeeComponent } from './form-fee.component';

describe('FormFeeComponent', () => {
  let component: FormFeeComponent;
  let fixture: ComponentFixture<FormFeeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormFeeComponent]
    });
    fixture = TestBed.createComponent(FormFeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
