package com.example.R2DBCpoc;

import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.convert.EnumWriteSupport;

@WritingConverter
public class LivestockPregnancyStatusWritingConverter extends EnumWriteSupport<EPregnancyStatus> {

}
