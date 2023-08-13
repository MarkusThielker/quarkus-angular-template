import { TestBed } from '@angular/core/testing';

import { HelloRemoteService } from './hello.remote.service';

describe('HelloRemoteService', () => {
  let service: HelloRemoteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HelloRemoteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
