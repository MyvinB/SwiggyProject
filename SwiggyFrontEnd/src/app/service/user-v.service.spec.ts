import { TestBed } from '@angular/core/testing';

import { UserVService } from './user-v.service';

describe('UserVService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserVService = TestBed.get(UserVService);
    expect(service).toBeTruthy();
  });
});
