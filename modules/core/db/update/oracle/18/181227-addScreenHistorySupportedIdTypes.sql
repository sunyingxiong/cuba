alter table SEC_SCREEN_HISTORY add STRING_ENTITY_ID varchar2(255);
alter table SEC_SCREEN_HISTORY add INT_ENTITY_ID integer;
alter table SEC_SCREEN_HISTORY add LONG_ENTITY_ID number;
create index IDX_SEC_SCREEN_HISTORY_ENTITY on SEC_SCREEN_HISTORY(ENTITY_ID);
create index IDX_SEC_SCREEN_HISTORY_SENTITY on SEC_SCREEN_HISTORY(STRING_ENTITY_ID);
create index IDX_SEC_SCREEN_HISTORY_IENTITY on SEC_SCREEN_HISTORY(INT_ENTITY_ID);
create index IDX_SEC_SCREEN_HISTORY_LENTITY on SEC_SCREEN_HISTORY(LONG_ENTITY_ID);