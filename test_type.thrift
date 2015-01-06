namespace java ming.yin.test

enum Type {
	MSG = 1,
	GMSG = 2,
	EVENT = 3
}

struct Location {
    1: required double latitude;
    2: required double longitude;
}

struct ImjPacket {

	1: optional string short_string_1;
	2: optional string short_string_2;
	3: optional string text;
	4: optional Location loc;

	5: optional Type type;

	6: optional i32 num_1;
	7: optional i32 num_2;
	8: optional i64 num_3;
	9: optional i64 num_4;
	10: optional i16 num_5;
	11: optional i16 num_6;
	12: optional double num_7;
	13: optional double its_a_num_8;
	14: optional byte its_a_num_9;
	15: optional byte its_a_num_10;

	16: optional bool b1;
	17: optional bool boolean_2;
}

struct Params {
	1: optional i64 fr;
	2: optional i64 to;
	3: optional map<i32, double> distances;
	4: optional ImjPacket imjpacket;
}

struct TestType {
	1: required i64 id;
	2: optional Params params;
	3: optional string action;
}