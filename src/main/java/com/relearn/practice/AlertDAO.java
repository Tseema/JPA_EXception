package com.relearn.practice;

import java.util.Date;
import java.util.UUID;

interface AlertDAO {

    public UUID addAlert(Date time);

    public Date getAlert(UUID id);
}
