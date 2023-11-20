package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SachThamKhao extends AnPham {
	private String linhVuc;
	private List<ChuongSach> dsChuongSach = new ArrayList<>();

	public SachThamKhao(String tenSach, int soTrang, int nam, String tacGia, int gia, String linhVuc,
			List<ChuongSach> dsChuongSach) {
		super(tenSach, soTrang, nam, tacGia, gia);
		this.linhVuc = linhVuc;
		this.dsChuongSach = dsChuongSach;
	}

	@Override
	public String toString() {
		return "tenSach=" + tenSach + ", soTrang=" + soTrang + ", nam=" + nam + ", tacGia=" + tacGia + ", gia=" + gia
				+ "linhVuc=" + linhVuc + ", dsChuongSach=" + dsChuongSach;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dsChuongSach, linhVuc);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SachThamKhao other = (SachThamKhao) obj;
		return Objects.equals(dsChuongSach, other.dsChuongSach) && Objects.equals(linhVuc, other.linhVuc);
	}

}
