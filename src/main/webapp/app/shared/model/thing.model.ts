import { ILocation } from 'app/shared/model/location.model';
import { IDevice } from 'app/shared/model/device.model';
import { IState } from 'app/shared/model/state.model';
import { IThingCategory } from 'app/shared/model/thing-category.model';
import { IApplication } from 'app/shared/model/application.model';

export interface IThing {
  id?: number;
  name?: string | null;
  location?: ILocation | null;
  devices?: IDevice[] | null;
  states?: IState[] | null;
  thingCategory?: IThingCategory | null;
  application?: IApplication | null;
}

export const defaultValue: Readonly<IThing> = {};
