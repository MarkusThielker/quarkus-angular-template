import { TestBed } from '@angular/core/testing';

import { TaskRemoteService } from './task.remote.service';

describe('TaskRemoteService', () => {
  let service: TaskRemoteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TaskRemoteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
