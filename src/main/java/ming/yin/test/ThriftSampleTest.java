package ming.yin.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.time.DurationFormatUtils;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TSimpleJSONProtocol;
import org.apache.thrift.transport.TMemoryBuffer;

import com.immomo.mcf.util.JsonUtils;

public class ThriftSampleTest {
	private final static String jsonRepresentation = "{\"id\":123456789012345678,\"params\":{\"fr\":123123123123123123,\"to\":456456456456456456,\"distances\":{\"10000074\":9.999926000547596E-8,\"10000075\":9.999925000562496E-8,\"10000072\":9.999928000518396E-8,\"10000073\":9.999927000532896E-8,\"10000078\":9.999922000608396E-8,\"10000079\":9.999921000624095E-8,\"10000076\":9.999924000577596E-8,\"10000077\":9.999923000592896E-8,\"10000066\":9.999934000435597E-8,\"10000067\":9.999933000448897E-8,\"10000064\":9.999936000409598E-8,\"10000065\":9.999935000422497E-8,\"10000070\":9.999930000489996E-8,\"10000071\":9.999929000504096E-8,\"10000068\":9.999932000462397E-8,\"10000069\":9.999931000476097E-8,\"10000091\":9.999909000828093E-8,\"10000090\":9.999910000809992E-8,\"10000089\":9.999911000792093E-8,\"10000088\":9.999912000774393E-8,\"10000095\":9.999905000902491E-8,\"10000094\":9.999906000883592E-8,\"10000093\":9.999907000864892E-8,\"10000092\":9.999908000846392E-8,\"10000083\":9.999917000688895E-8,\"10000082\":9.999918000672394E-8,\"10000081\":9.999919000656094E-8,\"10000080\":9.999920000639995E-8,\"10000087\":9.999913000756893E-8,\"10000086\":9.999914000739593E-8,\"10000085\":9.999915000722494E-8,\"10000084\":9.999916000705594E-8,\"10000096\":9.999904000921591E-8,\"10000097\":9.99990300094089E-8,\"10000098\":9.999902000960391E-8,\"10000099\":9.99990100098009E-8,\"10000014\":9.9999860000196E-8,\"10000015\":9.9999850000225E-8,\"10000012\":9.9999880000144E-8,\"10000013\":9.9999870000169E-8,\"10000010\":9.99999000001E-8,\"10000011\":9.9999890000121E-8,\"10000008\":9.9999920000064E-8,\"10000009\":9.9999910000081E-8,\"10000006\":9.9999940000036E-8,\"10000007\":9.9999930000049E-8,\"10000004\":9.9999960000016E-8,\"10000005\":9.9999950000025E-8,\"10000002\":9.9999980000004E-8,\"10000003\":9.9999970000009E-8,\"10000000\":1.0E-7,\"10000001\":9.9999990000001E-8,\"10000031\":9.9999690000961E-8,\"10000030\":9.999970000089999E-8,\"10000029\":9.9999710000841E-8,\"10000028\":9.9999720000784E-8,\"10000027\":9.9999730000729E-8,\"10000026\":9.9999740000676E-8,\"10000025\":9.999975000062499E-8,\"10000024\":9.9999760000576E-8,\"10000023\":9.9999770000529E-8,\"10000022\":9.9999780000484E-8,\"10000021\":9.9999790000441E-8,\"10000020\":9.99998000004E-8,\"10000019\":9.9999810000361E-8,\"10000018\":9.9999820000324E-8,\"10000017\":9.9999830000289E-8,\"10000016\":9.9999840000256E-8,\"10000044\":9.999956000193599E-8,\"10000045\":9.9999550002025E-8,\"10000046\":9.999954000211599E-8,\"10000047\":9.9999530002209E-8,\"10000040\":9.999960000159999E-8,\"10000041\":9.9999590001681E-8,\"10000042\":9.999958000176399E-8,\"10000043\":9.999957000184899E-8,\"10000036\":9.9999640001296E-8,\"10000037\":9.9999630001369E-8,\"10000038\":9.9999620001444E-8,\"10000039\":9.999961000152099E-8,\"10000032\":9.9999680001024E-8,\"10000033\":9.9999670001089E-8,\"10000034\":9.9999660001156E-8,\"10000035\":9.999965000122499E-8,\"10000061\":9.999939000372098E-8,\"10000060\":9.999940000359997E-8,\"10000063\":9.999937000396897E-8,\"10000062\":9.999938000384398E-8,\"10000057\":9.999943000324899E-8,\"10000056\":9.999944000313598E-8,\"10000059\":9.999941000348097E-8,\"10000058\":9.999942000336397E-8,\"10000053\":9.999947000280899E-8,\"10000052\":9.999948000270398E-8,\"10000055\":9.999945000302498E-8,\"10000054\":9.999946000291599E-8,\"10000049\":9.999951000240099E-8,\"10000048\":9.999952000230398E-8,\"10000051\":9.999949000260099E-8,\"10000050\":9.999950000249999E-8},\"imjpacket\":{\"short_string_1\":\"abcde\",\"short_string_2\":\"dfgh\",\"text\":\"aaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccddddddddddddddd\",\"loc\":{\"latitude\":37.1,\"longitude\":124.3},\"type\":2,\"num_1\":10,\"num_2\":31,\"num_3\":41111111111111,\"num_4\":222222222222222,\"num_5\":31111,\"num_6\":32767,\"num_7\":1.0,\"its_a_num_8\":1.0E-12,\"its_a_num_9\":97,\"its_a_num_10\":10,\"b1\":1,\"boolean_2\":0}},\"action\":\"imj_gmsg\"}";
	private static TestType init() {

		TestType testType = new TestType();
		testType.setAction("imj_gmsg");
		testType.setId(123456789012345678l);
		
		Params params = new Params();
		testType.setParams(params);
		params.setFr(123123123123123123l);
		params.setTo(456456456456456456l);
		
		params.setDistances(new HashMap<Integer, Double>());
		// 100 members
		for (int i = 10000000; i < 10000100; i++) {
			params.distances.put(i, 1.0 / i);
		}
		
		ImjPacket packet = new ImjPacket();
		params.setImjpacket(packet);
		packet.setB1(true);
		packet.setBoolean_2(false);

		packet.setShort_string_1("abcde");
		packet.setShort_string_2("dfgh");
		packet.setText("aaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccddddddddddddddd");
		
		packet.setLoc(new Location());
		packet.loc.setLatitude(37.1);
		packet.loc.setLongitude(124.3);
		
		packet.setType(Type.GMSG);
		packet.setNum_1(10);
		packet.setNum_2(31);
		packet.setNum_3(41111111111111l);
		packet.setNum_4(222222222222222l);
		packet.setNum_5((short)31111);
		packet.setNum_6((short)32767);
		packet.setNum_7(1.0);
		packet.setIts_a_num_8(1e-12);
		packet.setIts_a_num_9((byte)'a');
		packet.setIts_a_num_10((byte)'\n');
		
		return testType;
	}
	public static void main(String[] args) throws TException {
		TSerializer serializer = new TSerializer(new TBinaryProtocol.Factory());
		TDeserializer deserializer = new TDeserializer(new TBinaryProtocol.Factory());
		
		TestType testType = init();

		// int times = Integer.parseInt(args[1]);
		int times = 10000;
		
		long time = System.currentTimeMillis();
		
		for (int i = 0; i < times; i++) {
			byte[] encoded = serializer.serialize(testType);
			TestType testTypeGenerated = new TestType();
			deserializer.deserialize(testTypeGenerated, encoded);
			
			assert testType.equals(testTypeGenerated);
		}
		long completedIn = System.currentTimeMillis() - time;

		System.out.println(DurationFormatUtils.formatDuration(completedIn, "HH:mm:ss:SS"));
	}
}
