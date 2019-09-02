import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SwiggyComponent } from './swiggy.component';

describe('SwiggyComponent', () => {
  let component: SwiggyComponent;
  let fixture: ComponentFixture<SwiggyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SwiggyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SwiggyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
